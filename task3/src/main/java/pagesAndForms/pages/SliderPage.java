package pagesAndForms.pages;

import elements.Slider;
import elements.TextField;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class SliderPage extends BaseForm implements ClickLeftButtons {
    private final By SLIDER = By.xpath("//*[@type='range']");
    private final By SLIDER_VALUE = By.id("sliderValue");
    public SliderPage() {
        super(By.id("sliderContainer"), "SliderPage");
    }
    public void setSlider(int value){
        Slider slider = new Slider(SLIDER,"Slider");
        double width = slider.getWidth();
        double percents = width*value/100;
        int result = (int) ((percents + (-0.2*(value-50))));
        slider.setArrow(result);
        slider.waitAttributeValue(value,"value");

    }
    public int getMinValue(){
        return Integer.parseInt(new Slider(SLIDER,"Slider").getAttribute("min"));
    }
    public int getMaxValue(){
        return Integer.parseInt(new Slider(SLIDER,"Slider").getAttribute("max"));
    }
    public int getValue(){
        return Integer.parseInt(new TextField(SLIDER_VALUE,"SliderValue").getAttribute("value"));
    }

}
