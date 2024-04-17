import javax.swing.JComboBox;

/**
 *
 * @author russe
 * @param <E>
 */
public class ComboBox<E> extends JComboBox<E>{
    public ComboBox(){
        setUI(new ComboBoxUI());
    }
}
