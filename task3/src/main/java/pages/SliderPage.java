package pages;

import framework.elements.Container;
import framework.elements.Slider;
import framework.elements.TextField;
import org.openqa.selenium.By;
import framework.BaseForm;

public class SliderPage extends BaseForm {
    private final Slider SLIDER = new Slider(By.xpath("//*[@type='range']"),"Slider");
    private final TextField SLIDER_VALUE = new TextField(By.id("sliderValue"),"SliderValue");
    public SliderPage() {
        super(new Container(By.id("sliderContainer"),"uniqueElementSliderPage"), "SliderPage");
    }

    public void setSlider(int value){
        double width = SLIDER.getWidth();
        double percents = width*value/100;
        int result = (int) ((percents + (-0.2*(value-50))));
        SLIDER.setArrow(result);
        SLIDER.waitAttributeValue(value,"value");
    }

    public int getMinValue(){
        return Integer.parseInt(SLIDER.getAttribute("min"));
    }

    public int getMaxValue(){
        return Integer.parseInt(SLIDER.getAttribute("max"));
    }

    public int getValue(){
        return Integer.parseInt(SLIDER_VALUE.getAttribute("value"));
    }

}
