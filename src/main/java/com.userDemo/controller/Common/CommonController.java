package com.userDemo.controller.Common;

import com.userDemo.common.CookieUtil;

import com.userDemo.model.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommonController {
    @RequestMapping("/common/rightMenu")
    public String rightMenu(HttpServletRequest request) throws Exception {
      String [] user = CookieUtil.getLoginInfo(request);
        Map<String,Object> map = new HashMap<String,Object>();
      if (user!=null)
      {
         map.put("username",""+user[0]);
         map.put("islogin",true);
      }else{
          map.put("islogin",false);
      }
      return "/common/rightMenu";
    }
}
