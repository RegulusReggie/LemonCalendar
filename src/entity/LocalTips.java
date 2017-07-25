package entity;

import javafx.beans.property.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LocalTips {
    private StringProperty id = new SimpleStringProperty(UUID.randomUUID().toString());
    private StringProperty date = new SimpleStringProperty("");
    private StringProperty content = new SimpleStringProperty("");
    private BooleanProperty important = new SimpleBooleanProperty(false);
    private BooleanProperty display = new SimpleBooleanProperty(false);
    private BooleanProperty delete = new SimpleBooleanProperty(false);
    private IntegerProperty x_location = new SimpleIntegerProperty(0);
    private IntegerProperty y_location = new SimpleIntegerProperty(0);
    private BooleanProperty alarm = new SimpleBooleanProperty(false);
    private StringProperty alarmDate = new SimpleStringProperty("");
    private IntegerProperty opacity = new SimpleIntegerProperty(5);
    private IntegerProperty font_size = new SimpleIntegerProperty(15);
    private IntegerProperty color = new SimpleIntegerProperty(9689968);
    public LocalTips(String content){
        setContent(content);
    }
    public LocalTips(){
    }
    public void setId(String xid){   //dont use
        id.set(xid);
    }
    public String getId(){
        return id.get();
    }
    public final void setDate(String value){
        date.set(value);
    }
    public String getDate(){
        return date.get();
    }
    public final void setContent(String value){
        if(content == null){
            content = new SimpleStringProperty("123");
        }
        content.set(value);
    }
    public String getContent(){
        return content.get();
    }
    public final void setImportant(boolean value){
        important.set(value);
    }
    public boolean getImportant(){
        return important.get();
    }
    public final void setDisplay(boolean value){
        display.set(value);
    }
    public boolean getDisplay(){
        return display.get();
    }
    public final void setDelete(boolean value){
        delete.set(value);
    }
    public boolean getDelete(){
        return delete.get();
    }
    public final void setX_location(int x){
        x_location.set(x);
    }
    public int getX_location(){
        return  x_location.get();
    }
    public final void setY_location(int y){
        y_location.set(y);
    }
    public int getY_location(){
        return  y_location.get();
    }
    public final void setAlarm(boolean a){
        alarm.set(a);
    }
    public boolean getAlarm(){
        return alarm.get();
    }
    public final void setAlarmDate(String value){
        DateFormat internalTime = new SimpleDateFormat("HH:mm");
        DateFormat onceTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date alarmdt;
        try {
            alarmdt = internalTime.parse(value);
            alarmDate.set(internalTime.format(alarmdt));
        }catch (Exception e){
            try{
                alarmdt = onceTime.parse(value);
                alarmDate.set(onceTime.format(alarmdt));
            }catch (Exception ee){
                System.out.println("Invalid alarm time format!");
            }
        }
    }
    public String getAlarmDate(){
        return alarmDate.get();
    }
    public final void setOpacity(int value){
        opacity.set(value);
    }
    public int getOpacity(){
        return opacity.get();
    }
    public final void setFont_size(int value){
        font_size.set(value);
    }
    public int getFont_size(){
        return font_size.get();
    }
    public final void setColor(int value){
        color.set(value);
    }
    public int getColor(){
        return color.get();
    }
}
