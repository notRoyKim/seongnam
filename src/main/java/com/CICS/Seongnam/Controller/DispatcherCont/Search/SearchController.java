package com.CICS.Seongnam.Controller.DispatcherCont.Search;

import com.CICS.Seongnam.Domain.Main_Rand_Slide;
import com.CICS.Seongnam.Domain.Search_Result;
import com.CICS.Seongnam.Service.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/SearchResult", method = RequestMethod.GET)
    public ModelAndView base(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        String query = request.getParameter("query");

        List<Search_Result> result_list = new ArrayList<>();
        result_list = searchService.getSearchResultNo(query);

        mv.setViewName("Search/Searchresult");
        mv.addObject("query",query);
        mv.addObject("result_list",result_list);
        return mv;
    }
}
