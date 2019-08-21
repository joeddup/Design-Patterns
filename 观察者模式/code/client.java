public class Client{
	public static void main(String [] args){
		WeatherData data = new WeatherData();
		WebObserver observer1 = new WebObserver();
		data.registerObserver(observer1);
		....
	}
}