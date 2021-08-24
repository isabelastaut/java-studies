package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Post p1 = new Post(
				sdf.parse("12/06/2021 07:10:05"),
				"Traveling to New Zealand",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in nisi id dolor aliquet pulvinar.",
				13);
		
		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("Wow that's awesome!");
		p1.addCooment(c1);
		p1.addCooment(c2);
		
		Post p2 = new Post(
				sdf.parse("15/06/2021 07:36:12"),
				"Good night, guys",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in nisi id dolor aliquet pulvinar.",
				5);
		
		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("Have a good one!");
		p2.addCooment(c3);
		p2.addCooment(c4);
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
