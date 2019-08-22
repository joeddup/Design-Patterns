适配器模式：
	可以类比于生活中的手机充电器，手机充电器将220V的电压转化为5V的电压。充当了一个适配器的角色。
	适配器的作用即将一些原来一些现存的无法直接使用的类，经过包装后再使用。


适配器包括类适配器以及对象适配器。以手机充电为例：

类适配器：
	class Voltage220V:
		void outPut220V();

	interface Voltage5V:
		void outPut5V();

	class Adapter extends Voltage220V implements Voltage5V:
		@Override
		void outPut5V(){
			//调用outPut22V()方法将电压转化为5V
		}

	使用者例如手机，直接调用Adapter

对象适配器：
	class Voltage220V:
		void outPut220V();

	interface Voltage5V:
		void outPut5V();

	class Adapter implements Voltage5V:
		//持有一个被适配的对象，替代了继承的方式，在这里是Voltage220V
		Voltage220V voltage220V;
		public Adapter(Voltage220V voltage220V);//构造函数
		@Override
		void outPut5V(){
			//通过持有的voltage220V对象实现电压的转换
		}

接口适配器模式：
	interface IObject:
		public void m1();
		public void m2();
		...

	abstract IObjectAdapter implements IObject:
		//将接口里的方法都默认实现(一般是直接写空方法)
		public void m1(){}
		public void m2(){}
		...


	//Client就无需实现IObject里的所有的抽象方法，只需要new一个Adapter，重写自己用到的方法即可
	class Client {
		IObjectAdapter adapter = new IObjectAdapter{
			@Override
			public void m1(){
				//实现自定义的逻辑
				....
			}
		}
	}


对象适配器和类适配器的比较：
	对象适配器不用继承制定的类，更加灵活。

适配器模式在SpringMVC里的运用：

	interface Controller:

	各种实现：HttpController,SimpleController,AnnotationController


	interface HandlerAdapter:
		void supports();
		void handle();

	各种实现：HttpHandlerAdapter，SimpleHandleAdapter,AnnotationHandleAdapter


	DispathServlet:
		持有很多Adapter public static List<HandlerAdapter> handlerAdapters
		得到Contruller后调用getHandler(通过调用Adapter的supports方法判断哪个Adapter适合)
		获取到相应的Adapter，再调用Adapter的handle方法(通过调用Controller的具体方法)

SpringMVC 为什么要使用适配器模式？
	如果直接在DispathServlet中直接调用Controller的相关方法时，因为每种Controller里的方法不一样，就必须要首先通过
	一系列的if else来对不同的Controller调用不同的逻辑，这样的话一旦增加新的Controller，DispatchServlet里的代码逻辑也
	必须要跟着改变。
	而通过增加一层Adapter，在Adapter里的supports方法里确定Controller的类型，这样如果增加新的Controller时只需要加一个
	Adapter即可
	参考文章：https://blog.csdn.net/u010288264/article/details/53835185

























