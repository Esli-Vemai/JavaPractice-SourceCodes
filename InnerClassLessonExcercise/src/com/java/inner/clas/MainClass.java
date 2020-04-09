package com.java.inner.clas;

import java.util.Scanner;

public class MainClass {
	private static Scanner scanner = new Scanner(System.in);
	private static ButtonClassforAnonymousClassDemo btnPrint = new ButtonClassforAnonymousClassDemo("Print");;

	public static void main(String[] args) {
		GearBox mcLaren = new GearBox(6);
		// GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//        Gearbox.Gear second = new Gearbox.Gear(2, 15.4);
//        Gearbox.Gear third = new mcLaren.Gear(3, 17.8);
		// System.out.println(first.driveSpeed(1000));
		mcLaren.operateClutch(true);
		mcLaren.changeGear(2);
		mcLaren.operateClutch(false);
		System.out.println(mcLaren.wheelSpeed(100));
		mcLaren.changeGear(4);
		System.out.println(mcLaren.wheelSpeed(200));
		mcLaren.operateClutch(true);
		mcLaren.changeGear(7);
		System.out.println(mcLaren.wheelSpeed(300));
		mcLaren.changeGear(5);
		mcLaren.operateClutch(false);
		System.out.println(mcLaren.wheelSpeed(300));

		// Example of Local class
		//class ClickListener implements ButtonClassforAnonymousClassDemo.OnClickClass {
			//public ClickListener() {
			//	System.out.println("I've been attached");
			//}

			//@Override
			//public void onClick(String title) {
			//	System.out.println(title + " was clicked");
		//	}
		//}

		//btnPrint.setOnClickClass(new ClickListener());

	//}
		
		
		
		//Example of Anonymous class - class without name
		btnPrint.setOnClickClass(new ButtonClassforAnonymousClassDemo.OnClickClass() {

			@Override
			public void onClick(String title) {
			System.out.println(title + " was clicked");
				
			}
					
		});
		listen();
		}

	private static void listen() {
		boolean quit = false;
		while (!quit) {
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 0:
				quit = true;
				break;
			case 1:
				btnPrint.onClick();

			}
		}
	}

}
