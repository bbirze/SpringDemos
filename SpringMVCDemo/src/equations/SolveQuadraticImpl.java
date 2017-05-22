package equations;

import org.springframework.stereotype.Component;

@Component("solveQuadratic")
public class SolveQuadraticImpl implements SolveQuadratic {

	@Override
	public double getRoot1(double a, double b, double c) {
		return (-b + Math.sqrt((b*b) - (4*a*c)) / 2*a);
	}

	@Override
	public double getRoot2(double a, double b, double c) {
		return (-b - Math.sqrt((b*b) - (4*a*c)) / 2*a);
	}

}
