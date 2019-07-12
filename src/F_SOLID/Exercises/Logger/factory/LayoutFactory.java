package F_SOLID.Exercises.Logger.factory;

import F_SOLID.Exercises.Logger.interfaces.Factory;
import F_SOLID.Exercises.Logger.interfaces.Layout;
import F_SOLID.Exercises.Logger.models.SimpleLayout;
import F_SOLID.Exercises.Logger.models.XmlLayout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String produceData) {

        Layout layout = null;

        if (produceData.equals("SimpleLayout")) {
            layout = new SimpleLayout();
        } else if (produceData.equals("XmlLayout")) {
            layout = new XmlLayout();
        }

        return layout;
    }
}
