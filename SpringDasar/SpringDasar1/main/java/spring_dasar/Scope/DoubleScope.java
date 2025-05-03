package spring_dasar.Scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

//membuat scope sendiri
public class DoubleScope implements Scope {
    //membuat double scope

    private List<Object> objects = new ArrayList<>(2);
    private Long counter = -1L;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        counter++;//pertamakali counter dinaikan

        if (objects.size() == 2){//cek size, jika 2 dia akan kesini
            int index = (int) (counter % 2);//jika 2 dia akan membalikan counter sebelumnya
            return objects.get(index);
        }else {//jika belum 2 diakan kesini
            Object object = objectFactory.getObject();//membuat object baru
            objects.add(object);//add ke list object
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        if (!objects.isEmpty()){//jika memiliki data
            return objects.remove(0);//dia akan menghapus data index ke 0
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "";
    }


}
