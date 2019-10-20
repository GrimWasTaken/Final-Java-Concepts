package Lambda;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

interface Operate{
	public int add(int whatToAdd);
}

interface Filler{
	public String fill();
}

interface Supplier<Type> {
    Type get();
}

public class LambdaDemo{
	public static void main(String[] args) {
		
				//Lambda section
				//Define single abstract methods
				Operate doMath = a -> a += 5;
				Filler baster = () -> "Jelly Donut";
				
				//Define variables that implement said methods
				String food = baster.fill();
				int num = doMath.add(5);
				
				//Display results
				System.out.println(num);
				System.out.println(food);

				
				//Method reference section
				Supplier<String> response = baster :: fill;
				
				//Display results
				System.out.println(response.get());
				
				
				//Stream section
		        Stream<String> burger = Stream.of("Cheese", "Burger"); 
		        
		        burger.forEach(b -> System.out.print(b)); 
	}
}