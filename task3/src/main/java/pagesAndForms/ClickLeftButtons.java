package pagesAndForms;

import elements.Button;

public interface  ClickLeftButtons {
    //Мне интересно, так лучше делать? Или расписывать эти кнопки для всех страниц
    //Суть - Я создал Enum куда поместил все кнопки которые находяться в левом блоке и реализовал метод где мы выбираем
    //нужную кнопку, и ставим интерфейс везде где есть левый блок
    default void click(LeftPanelButtons dataButton) {
        Button button = new Button(dataButton.getLocator(),dataButton.getName());
        if(!button.isVisibilityNow()){
            openBlock(dataButton.getParent());
        }
        button.click();
    }

    private void openBlock(LeftPanelButtons dataButton) {
        new Button(dataButton.getLocator(),dataButton.getName()).click();
    }
}
