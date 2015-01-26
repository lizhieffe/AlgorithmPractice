package FrequencyCountOverDataStream;

import java.util.List;
import java.util.Scanner;

public class Server {
	
	volatile private boolean running = false;
	private StringStreamQueue queue = new StringStreamQueue();
	private FrequencyCount fc = new FrequencyCount(queue);
	
	public void start() {
		if (running) {
			System.out.println("Server is already running");
			return;
		}
		running = true;
		System.out.println("Server is started");
		System.out.println("Server is running");
		boolean stop = false;
		Scanner sc = new Scanner(System.in);
		while (!stop) {
			String[] s = sc.nextLine().split(" ");
			for (String tmp : s) {
				if (tmp.equals("[s]")) {
					stop = true;
					break;
				}
				else if (tmp.equals("[p]"))
					printTopFrequency(10);
				else
					queue.add(tmp);
			}	
		}
		running = false;
		System.out.println("Server stops");
	}
	
	public void printTopFrequency(int n) {
		List<CountEntry> list = getTopFrequency(n);
		for (CountEntry e : list)
			System.out.println("[" + e.s + "]: " + e.count);
	}
	public List<CountEntry> getTopFrequency(int n) {
		return fc.getTopFrequency(n);
	}
	
	public static void main(String[] args) {
		Server s = new Server();
		s.start();
	}
}
