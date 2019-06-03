package com.rsampdev.inTheDark;

import java.util.Random;
import java.util.Scanner;

class Game {

	private Random dice = new Random();
	private Player player;

	Game(Player player) {
		this.player = player;
	}

	void prepare() {
		Item.prepare();
	}

	String run(Scanner terminal) {
		String commandListener = "";
		String input = "";

		System.out.println("\nWhat do you want to do?");
		System.out.println("ENTER: explore, stats, help or quit\n");

		input = terminal.nextLine().toLowerCase().trim();

		if (input.equals(Command.EXPLORE.getValue())) {
			explore(terminal);
		} else if (input.equals(Command.STATS.getValue())) {
			stats();
		} else {
			commandListener = input;
		}

		return commandListener;
	}

	void explore(Scanner terminal) {
		int number = dice.nextInt(6);

		String input = "";

		if (number <= 1) {

			System.out.println("You have encountered nothing. But the tunnel continues onward...");

		}

		if (number == 2) {

			while (!input.equals("left") && !input.equals("right")) {
				System.out.println("You have come to an intersection, do you go left of right?");
				input = terminal.nextLine().toLowerCase().trim();
			}

			explore(terminal);

		}

		if (number == 3) {

			Item item = Item.getRandomItem();
			player.addItem(item);

			System.out.println("\nYou have found a(n) " + item.getName() + "\n");

			while (!input.equals("yes") && !input.equals("no")) {
				System.out.println("Do you want to use the " + item.getName() + " now?\n");

				input = terminal.nextLine().toLowerCase().trim();

				if (input.equals("yes")) {
					player.useItem(item.getName());
				}
			}

		}

		if (number == 4) {

			System.out.println("You have encountered an enemy.");

			// Enemies and monsters

		}

		if (number == 5) {

			System.out.println("Another path...");

			// Another path...

		}

	}

	void stats() {
		System.out.println(player.getStats() + "\n");
	}

}
