package doubleAss.pijama.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import doubleAss.pijama.common.util.Pagination;
import doubleAss.pijama.entity.Contact;
import doubleAss.pijama.service.ContactService;
import doubleAss.pijama.utils.WebUtils;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @GetMapping({"/contact", "/contact123"})
    public String list(Model model,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
            @RequestParam(name = "totalPageResult", required = false, defaultValue = "5") Integer totalPageResult,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

        Sort sortable = null;
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        } else {
            sortable = Sort.by("id").ascending();
        }
        
        long totalItems = contactService.count();
        
        Pagination pagination = new Pagination();
        
        List<Integer> listPage = pagination.listPage(page, totalItems, size, totalPageResult);
        
        Pageable pageable = PageRequest.of((page-1), size, sortable);
        String url = "/contact?";
        
        //set attribute
        model.addAttribute("contacts", contactService.findAll(pageable));
        model.addAttribute("firstPage", pagination.getFirstPage());
        model.addAttribute("lastPage", pagination.getLastPage());
        model.addAttribute("pageNext", pagination.getPageNext());
        model.addAttribute("pagePre", pagination.getPagePre());
        model.addAttribute("listPage", listPage);
       
        model.addAttribute("url", url);
        return "list";
    }

    @GetMapping("/contact/search")
    public String search(@RequestParam("term") String term, 
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "totalPageResult", required = false, defaultValue = "5") Integer totalPageResult,
            @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/contact";
        }
        
        Sort sortable = null;
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        } else {
            sortable = Sort.by("id").ascending();
        }
        
        long totalItems = contactService.countByNameContaining(term);
        Pagination pagination = new Pagination();
        List<Integer> listPage = pagination.listPage(page, totalItems, size, totalPageResult);
        
        Pageable pageable = PageRequest.of((page-1), size, sortable);
        String url = "/contact/search?term=" + term + "&";
        
        model.addAttribute("contacts", contactService.search(term, pageable));
        
        model.addAttribute("firstPage", pagination.getFirstPage());
        model.addAttribute("lastPage", pagination.getLastPage());
        model.addAttribute("pageNext", pagination.getPageNext());
        model.addAttribute("pagePre", pagination.getPagePre());
        model.addAttribute("listPage", listPage);
        
        model.addAttribute("term", term);
        model.addAttribute("url", url);
        return "list";
    }

    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect,
            @RequestParam("fileData") MultipartFile file) {
        if (result.hasErrors()) {
            return "form";
        }
        
        try {
            String UPLOADED_FOLDER = "D://";
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }

//    @PostMapping("/upload_image")
//    @ResponseBody
//    public Map<String, String> uploadImage(
//            @RequestParam("file") MultipartFile file){
//        Map<String, String> responseData = new HashMap<>();
//
//        try {
//            String UPLOADED_FOLDER = "D:\\Tools\\WorkSpace\\Pijama\\src\\main\\resources\\static\\files\\";
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        String linkName = "http://localhost:8080/files/" + file.getOriginalFilename();
//        responseData.put("link", linkName);
//        // Send response data.
//        return responseData;
//    }
    
    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return "form";
    }

    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/contact";
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
            + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}
