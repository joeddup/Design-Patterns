观察者模式：一个或者多个对象会注册到一个服务提供者对象上，当这一个对象发生改变时会通知它内部所持有的其他一个或者多个对象。

以天气订阅为例：

抽象类两个：
Subject:
	List<Observer> observer;//持有的所有观察者
	void notify();//当内容发生更新时通知注册到它身上的所有观察者
	void registerObserver();//注册观察者
	void removeObserver();//将观察者移除

Observer:
	void update();//更新天气数据，由Subject的子类调用
	void display();//展示天气情况

两种实现类:
WeatherData implement Subject

WebObserver implements Observer
AppObserver implements Observer
...

