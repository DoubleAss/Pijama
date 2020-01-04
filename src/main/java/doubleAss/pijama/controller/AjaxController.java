package doubleAss.pijama.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

    @Autowired
    private ServletContext servletContext;

//    @ResponseBody
//    @PostMapping("activebill")
//    public String activeuser(@RequestParam("aid") int aid, @RequestParam("astatus") int astatus) {
//        int id = aid;
//        int status = astatus;
//        String html = "";
//        if(status == 0) {
//            if(billDao.updateActive(aid, astatus) > 0) {
//                status = 1;
//                html = "<a href=\"javascript:void(0)\" onclick=\"return getStatusForBill(" + id + ", " + status + ")\">";
//                html += "<c:set var='sum_total_price' value='${sum_total_price + objBill.total_price}'></c:set>";
//                html += "<img src=\"" + servletContext.getContextPath() + "/adminUrl/images/active.gif\"/>";
//                html += "</a>";
//            }
//
//        } else {
//            if(billDao.updateActive(id, status) > 0) {
//                status = 0;
//                html = "<a href=\"javascript:void(0)\" onclick=\"return getStatusForBill(" + id + ", " + status + ")\">";
//                html += "<img src=\"" + servletContext.getContextPath() + "/adminUrl/images/deactive.gif\"/>";
//                html += "</a>";
//            }
//        }
//        return html;
//    }
}
