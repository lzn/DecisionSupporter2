package pl.wdec.dsup.model;


import java.math.BigDecimal;
import java.util.ArrayList;

import pl.wdec.dsup.data.Decisions;
import pl.wdec.dsup.data.GameProperties;
import pl.wdec.dsup.data.Point;
import pl.wdec.dsup.data.Simulation;

public class Model {

	private GameProperties gp;
	private Simulation simulation;
	private ArrayList<GameProperties> gpHistory = new ArrayList<GameProperties>();

	public Model() {
		setGameProperties(new GameProperties());
		setSimulation(new Simulation(gp.cash, new BigDecimal(0.00D),
				new BigDecimal(0.00D)));
	}

	public GameProperties getGameProperties() {
		return gp;
	}

	public void setGameProperties(GameProperties gp) {
		if (this.gp != null)
			gpHistory.add(this.gp); // TODO: Usunąć
		this.gp = gp;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public Simulation getSimulation() {
		return this.simulation;
	}

	public ArrayList<Decisions> calculateDecisions(){
		ArrayList<Decisions> list = new ArrayList<Decisions>();
		
		for (int i = 0; i < 100; i = i + 10) {
			list.add(new Decisions((int)(Math.random()*1000), (int)(Math.random()*100), Math.random()*50, new Point(Math.random()*5000, Math.random())));
		}
		
		return list;
		
	}
	
	public Decisions getDecisionFor(Integer quantity, Integer quality, Double price){
		
		return null;
	}

}
