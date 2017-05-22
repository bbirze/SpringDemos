package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.corba.se.pept.transport.ContactInfo;

import equations.SolveQuadratic;


// controller will respond to a URL that ends in "/formula.html".
//
@Controller
@RequestMapping("/formula")
public class QuadraticEquationController {

	@Autowired 
	private ApplicationContext ctx;
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("a", "1");
		model.addAttribute("b", "3");
		model.addAttribute("c", "-4");
		return "formula";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@RequestParam double a, @RequestParam double b,
							 @RequestParam double c, Model model) {
		
		SolveQuadratic solver = (SolveQuadratic)ctx.getBean("solveQuadratic");

		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", c);

		model.addAttribute("root1", solver.getRoot1(a, b, c));
		model.addAttribute("root2", solver.getRoot2(a, b, c));

		
		return "roots";
	}

}
