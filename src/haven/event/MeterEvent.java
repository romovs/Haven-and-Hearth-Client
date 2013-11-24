package haven.event;

import java.awt.Color;

public class MeterEvent extends MaidEvent {
	public enum Type {
		HP,
		STAMINA,
		HUNGER,
		HAPINESS,
		AUTHORITY
	}
	
	private Type type;
	private Object[] values;
	public MeterEvent(Type type, Object[] values) {
		this.type = type;
		this.values = values;
	}

	public Type getType() {
		return type;
	}

	public Object[] getValues() {
		return values;
	}
	
	public MeterEventObject getEventObject() {

		if (type == Type.STAMINA || type == Type.AUTHORITY) {
			return new MeterEventObjectStamina((Integer)values[1]);
		} else if (type == Type.HUNGER) {

			if (((Color)values[0]).equals(new Color(96,0,0)) && 
				((Color)values[2]).equals(new Color(255,64,0))) {	
				return new MeterEventObjectHunger(MeterEventObjectHunger.HungerType.VERY_HUNGRY, (Integer)values[1]);
			} else if (((Color)values[0]).equals(new Color(255,64,0)) && 
				((Color)values[2]).equals(new Color(255,192,0))) {	
				return new MeterEventObjectHunger(MeterEventObjectHunger.HungerType.HUNGRY, (Integer)values[1]);
			}
			
			return null;	// TODO
			
		} else if (type == Type.HP) {
			return null;	// TODO
		} else {
			return null;	// TODO
		}
	}
}
