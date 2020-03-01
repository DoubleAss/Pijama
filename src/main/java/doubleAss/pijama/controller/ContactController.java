package doubleAss.pijama.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import doubleAss.pijama.common.util.DatetimeUtil;
import doubleAss.pijama.common.util.Pagination;
import doubleAss.pijama.entity.Contact;
import doubleAss.pijama.service.ContactService;

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
        
        // Setup phan trang
        Pagination pagination = new Pagination(page, totalItems, size, totalPageResult);
        
        Pageable pageable = PageRequest.of((page-1), size, sortable);
        
        String url = "/contact?page=";

        var contactList = contactService.findAll(pageable);
        contactList.forEach(c -> {
            c.setCreateDate(DatetimeUtil.displaySystemDate(c.getCreateDate()));
            c.setUpdateDate(DatetimeUtil.displaySystemDate(c.getUpdateDate()));
        });
        
        //set attribute
        model.addAttribute("contacts", contactList);
        model.addAttribute("pagination", pagination);
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
        
        long totalItems = contactService.countBySearch(term);
        
        //Setup Phan trang
        Pagination pagination = new Pagination(page, totalItems, size, totalPageResult);
        
        Pageable pageable = PageRequest.of((page-1), size, sortable);
        String url = "/contact/search?term=" + term + "&page=";

        var contactList = contactService.searchAllProperties(term, pageable);
        contactList.forEach(c -> {
            c.setCreateDate(DatetimeUtil.displaySystemDate(c.getCreateDate()));
            c.setUpdateDate(DatetimeUtil.displaySystemDate(c.getUpdateDate()));
        });

        model.addAttribute("contacts", contactList);
        model.addAttribute("pagination", pagination);
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
            @RequestParam("fileData") MultipartFile file, HttpServletRequest request) {
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
        String regex = "#\\w+";
        String link = "<a href=\"" + request.getRequestURL() + "/search?term=%s\" target=\"_blank\" >%s</a>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contact.getContent());
        while (matcher.find())
        {
            System.out.println("nhatnm11" + matcher.group());
            contact.setContent(contact.getContent().replace(
                    matcher.group(0), String.format(link, matcher.group().replace("#", ""), matcher.group())));
            System.out.println("nhatnm12" + contact.getContent());
//            System.out.println("nhatnm11" + matcher.group(2));
        }
//        contact.setContent(Pattern.compile(regex).matcher(contact.getContent()).replaceAll("abc"));

        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }

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

}
