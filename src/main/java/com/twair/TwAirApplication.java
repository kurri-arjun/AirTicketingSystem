package com.twair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class TwAirApplication {
	@RequestMapping("/")
	public String home(Model model) {
        model.addAttribute("locations", DataSource.instance().fetchLocations());
		return "FlightSearch";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute(value="searchForm") SearchForm searchForm, Model model) throws Exception {
		model.addAttribute("locations", DataSource.instance().fetchLocations());
		try {
			FlightSearch matchingFlights = DataSource.instance().fetchFlights().byLocationAndAvailableSeats(searchForm.getFrom(), searchForm.getTo(), searchForm.getPassengers());
			String date = searchForm.getDate();
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date startDate = (Date)formatter.parse(date);
			matchingFlights = matchingFlights.searchByDate(startDate);
			model.addAttribute("flights", matchingFlights.getFlightList());
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("flights", new ArrayList());
		}
		return "FlightSearch";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TwAirApplication.class, args);
	}
}
