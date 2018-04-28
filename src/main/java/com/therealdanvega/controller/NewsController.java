package com.therealdanvega.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.therealdanvega.domain.News;
import com.therealdanvega.service.NewsService;

import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService userService;

    public NewsController(NewsService userService) {
    	System.err.println("DDDDDDDDDDDDDDD");
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<News> list(@RequestParam(value = "orderBy", required = false) List<String> orderBy) {
    	if(orderBy == null||orderBy.isEmpty())
        return userService.list();
    	Order[] list =  new Order[orderBy.size()];
    	for (int j = 0; j < orderBy.size(); j++) {
        	list[j]= new Order(orderBy.get(j));

		}
        return userService.filter(list);

    }
    @GetMapping("/query")
    public News query(			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "date", required = false) final String date) {
if(title!=null&&!title.trim().isEmpty())
        {try {
			return userService.getByTitle(title);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
        
if(date==null||date.trim().isEmpty())
{
	return null;}

        System.err.println(date);
        try {
			return userService.getByDate(date);
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
return null;
    }
/**
 * 
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "news" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<Object> sesionGet(
			HttpServletRequest request,
			HttpServletResponse httpServletResponse,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "date", required = false) final String date) {
		if (orderBy != null) {
			List<Comparator<NewsDetails>> comparators = new ArrayList<Comparator<NewsDetails>>();
			for (int i = 0; i < orderBy.size(); i++) {
				if (NewsDetails.Comparators.comparatorMap.containsKey(orderBy
						.get(i))) {

					comparators.add(NewsDetails.Comparators.comparatorMap
							.get(orderBy.get(i)));
				} else {

					httpServletResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY
							.value());
					return new ResponseEntity<Object>("Invalid sorting parameters",
							HttpStatus.BAD_GATEWAY);
				}
				Collections.sort(data,
						ComparatorUtils.chainedComparator(comparators));

			}
		}
		if (title != null && !title.trim().isEmpty()) {
			Collections.sort(data,
					NewsDetails.Comparators.comparatorMap
					.get("title"));
			int i = Collections.binarySearch(data,new NewsDetails(null, null,  title,
					null, null),NewsDetails.Comparators.comparatorMap
					.get("title"));
			if(i>=0)
			{
			return new ResponseEntity<Object>(data.get(i), HttpStatus.OK);
			}
			return new ResponseEntity<Object>("no matching results", HttpStatus.OK);

			
		}
		if (date != null && !date.trim().isEmpty()) {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date queryDate = null;
	        try {
	        	queryDate=formatter.parse(date);
			} catch (ParseException e) {

			}
			if(queryDate==null){
				httpServletResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY
						.value());
				return new ResponseEntity<Object>("Malformed date time",
						HttpStatus.BAD_GATEWAY);
			}
			Collections.sort(data,
					NewsDetails.Comparators.comparatorMap
					.get("date"));

			int i = Collections.binarySearch(data,new NewsDetails(null, queryDate,  null,
					null, null),NewsDetails.Comparators.comparatorMap
					.get("date"));
			
			if(i<=0&&data.size()>(1*-1))
			{
			return new ResponseEntity<Object>(data.get((i*-1) -1), HttpStatus.OK);
			}
			return new ResponseEntity<Object>("no matching results", HttpStatus.OK);
			}
		return new ResponseEntity<Object>(data, HttpStatus.OK);

	}

}
 */
}
