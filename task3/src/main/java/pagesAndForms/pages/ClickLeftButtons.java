package pagesAndForms.pages;

import elements.Button;

public interface ClickLeftButtons {
    //Мне интересно, так лучше делать? Или расписывать эти кнопки для всех страниц
    default void open(LeftPanelButtons dataButton) {
        Button button = new Button(dataButton.getLocator(),dataButton.getName());
        if(!button.isVisibility()){
            new Button(dataButton.getParent().getLocator(),dataButton.getParent().getName()).click();
        }
        button.scrollToElement();
        button.click();
    }
}
