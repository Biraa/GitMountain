package ch.fhnw.oop;

import javafx.beans.property.Property;


public class ValueChangeCommand<T> implements Command {
	private final MountainPM mountainPM;
	private final Property<T> property;
	private final T           oldValue;
	private final T           newValue;

	public ValueChangeCommand(MountainPM mountainPM, Property<T> property, T oldValue, T newValue) {
		this.mountainPM = mountainPM;
		this.property = property;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public void undo() {
		mountainPM.setPropertyValueWithoutUndoSupport(property, oldValue);
	}

	public void redo() {
		mountainPM.setPropertyValueWithoutUndoSupport(property, newValue);
	}
}
