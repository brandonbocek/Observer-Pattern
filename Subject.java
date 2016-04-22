package Observer;

//the Subject is above the Observers in the hierarchy
//so the subject passes information to observers
//observers are really the stockgrabbers though bc subject is just an interface
public interface Subject {

	public abstract void register(Observer o);
	public void unregister(Observer o);
	public void notifyObserver();
	
}
