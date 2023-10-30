import java.util.Scanner;

abstract class Remote {
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void up();
	public abstract void down();
}

class TV extends Remote {
	int volume = 50;

	public void turnOn() {
		System.out.println("turning on");
	}

	public void turnOff() {
		System.out.println("turning off");
	}

	public void up() {
		volume++;
	}

	public void down() {
		volume--;
	}
}

class airCon extends Remote {
	int temp = 16;

	public void turnOn() {
		System.out.println("turning on");
	}

	public void turnOff() {
		System.out.println("turning off");
	}

	public void up() {
		temp++;
	}

	public void down() {
		temp--;
	}
}

public class main {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TV tv = new TV();
		airCon aircon = new airCon();

		System.out.println("chosse your device: ");
		System.out.println("1 : TV");
		System.out.println("2 : AIRCON");
		int getDevice = 0;

		while(getDevice != 1 && getDevice != 2) {
			getDevice = scanner.nextInt();
			if(getDevice != 1 && getDevice != 2) {
				System.out.print("You can only type 1 or 2");
			}
			System.out.print("\n");
		}
		scanner.nextLine();

		if(getDevice == 1) {
			String tvTurn = onOrOff();
			System.out.print("\n");

			switch(tvTurn) {
				case "on":
					boolean breaker = true;
					System.out.println("type \"+\" or \"-\" for volume up or down");
					System.out.println("type \"q\" to exit");
					while(breaker) {
						System.out.println("current volume : " + tv.volume);
						String tvSign = scanner.nextLine();
						switch(tvSign) {
							case "+":
								if(tv.volume < 100) {
								tv.up();
								break;
							} else {
								System.out.println("This is max volume");
								continue;
							}
							case "-":
								if(tv.volume > 0) {
								tv.down();
								break;
								} else {
									System.out.println("This is min volume");
									continue;
								}
							case "q":
								breaker = false;
								break;
						}
					}
					break;

				default:
					System.out.println("You have turned off the TV");
					break;
			}
		} else {

			String acTurn = onOrOff();
			System.out.print("\n");

			switch(acTurn) {
				case "on":
					boolean breaker = true;
					System.out.println("type \"+\" or \"-\" for temperature up or down");
					System.out.println("type \"q\" to exit");
					while(breaker) {
						System.out.println("current temperature : " + aircon.temp);
						String acSign = scanner.nextLine();
						switch(acSign) {
							case "+":
								if(aircon.temp < 32) {
									aircon.up();
									break;
								} else {
									System.out.println("This is max temperature");
									continue;
								}
							case "-":
								if(aircon.temp > 16) {
								aircon.down();
								break;
								} else {
									System.out.println("This is min temperature");
									continue;
								}
							case "q":
								breaker = false;
						}
					}
					break;
					
				default:
					System.out.println("You have turned off the AC");
					break;
			}
		}
	}
	public static String onOrOff() {
		System.out.println("type \"on\" or \"off\"");
		String turn = null;

		boolean onCheck = true;
		while(onCheck) {
			turn = scanner.nextLine();
			switch(turn) {
				case "on":
					onCheck = false;
					break;
				case "off":
					onCheck = false;
					break;
				default:
					System.out.println("You need to type \"on\" or \"off\"");
					break;
				}
			}
		return turn;
	}
}