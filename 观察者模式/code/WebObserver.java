class WebObserver implements Observer{
    private String temperatrue;
    private String humidity;
    //展示天气信息
    public void display(){
        System.out.print(temperatrue);
        System.out.print(humidity);
    }
    public void update(String temperatrue,String humidity){
        this.humidity = humidity;
        this.temperatrue = temperatrue;
        display();
    }
}