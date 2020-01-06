package doubleAss.pijama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import doubleAss.pijama.service.ContactService;

@Controller
public class AjaxController {

    @Autowired
    private ContactService contactService;

    @ResponseBody
    @PostMapping("contact/activeContact")
    public String activeContact(@RequestParam("aid") int aid, @RequestParam("astatus") int astatus) {
        int id = aid;
        int status = astatus;
        String html = "";
        if(status == 0) {
            status = 1;
            if(contactService.isUpdatedStatusContact(id, status) != 0) {
                html = "<a href='javascript:void(0)' onclick='getStatusForContact(" + id + ", " + status + ")'>";
                html += "<img src='../../images/active.gif'/>";
                html += "</a>";
            }

        } else {
            status = 0;
            if(contactService.isUpdatedStatusContact(id, status) != 0) {
                html = "<a href='javascript:void(0)' onclick='getStatusForContact(" + id + ", " + status + ")'>";
                html += "<img src='../../images/deactive.gif'/>";
                html += "</a>";
            }
        }
        return html;
    }
}
