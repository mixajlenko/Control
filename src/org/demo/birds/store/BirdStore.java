
package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Отнаследоваться от AbstractBirdStore.
 *
 * Реализовать паттерн Singleton.
 */
    public class BirdStore extends AbstractBirdStore {

    private static BirdStore instance;
    private List<Bird> listBird = new ArrayList<>();
    private List<Bird> listLivingArea = new ArrayList<>();

    private BirdStore(){}

    public static BirdStore getInstance(){
        if(instance == null){
            instance = new BirdStore();
        }
        return instance;
    }

    @Override
    public void addBird(Bird b) {
        boolean name = false;
        for (int i = 0; i < listBird.size() ; i++) {
            if (b.getName().equals(listBird.get(i).getName())) {
                name = true;
                System.out.println("Bird With name "+ b.getName() +" already exists");
            }
        }
        if (name == false) {
            listBird.add(b);
        }
    }

    @Override
    public Bird searchByName(String nameToSearch) {
        for (int i = 0; i < listBird.size(); i++) {
            if (nameToSearch.equals(listBird.get(i).getName())) {
                return listBird.get(i);
            }
        }
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {
        listLivingArea.clear();
        for (int i = 0; i < listBird.size(); i++) {
            if (livingAreaToFind.equals(listBird.get(i).getLivingArea())) {
                listLivingArea.add(listBird.get(i));
            }
        }
        if (listLivingArea.size() != 0) {
            return listLivingArea;
        }
        return null;

    }
}


