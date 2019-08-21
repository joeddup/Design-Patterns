class  WeatherData implements Subject{
    private String temperatrue;//温度
    private String humidity;//湿度
    public List<Observer> observers;


    //获取最新的天气值，并更新所持有的观察者
    public void setData(String temperatrue,String himitity){
        this.humidity = humidity;
        this.temperatrue = temperatrue;
        notify();
    }
    //遍历所有的观察者
    public viod notify(){
        for(Observer observer:observers){
            observer.update();
        }
    }
    //注册一个观察者
    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    //移除一个观察者
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }






}