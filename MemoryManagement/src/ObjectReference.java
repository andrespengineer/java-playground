import java.util.HashMap;

public class ObjectReference {

    public static void main(String[] args) {

        MagicDictionary magicDictionary = new MagicDictionary();

        magicDictionary.put('a', 1);
        magicDictionary.put('b', 1);
        magicDictionary.put('a', 2);
        try {
            System.out.println(magicDictionary.get('a'));
            magicDictionary.putAll(5);

            magicDictionary.put('a', 2);
            magicDictionary.putAll(7);
            System.out.println(magicDictionary);
            System.out.println(magicDictionary.get('a'));
            System.out.println(magicDictionary.get('b'));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


class TimedValue {
    int value;
    int timestamp;

    public TimedValue(int value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "Value: " + this.value + " " + "Time: " + this.timestamp;
    }
}
class MagicDictionary {

    private final HashMap<Character, TimedValue> hashMap = new HashMap<>();
    private final TimedValue timedValue = new TimedValue(0, 0);

    public void put(Character key, int value)
    {
        hashMap.putIfAbsent(key, new TimedValue(value, timedValue.timestamp + 1));
        hashMap.get(key).timestamp = timedValue.timestamp + 1;
        hashMap.get(key).value = value;
    }

    public int get(Character key) throws Exception {
        if(!hashMap.containsKey(key))
            throw new Exception("Key not found exception");

        return hashMap.get(key).timestamp > timedValue.timestamp
                ? hashMap.get(key).value : timedValue.value;
    }

    public void putAll(int value){
        this.timedValue.value = value;
        this.timedValue.timestamp++;
    }

    @Override
    public String toString(){
        return hashMap.toString();
    }
}
