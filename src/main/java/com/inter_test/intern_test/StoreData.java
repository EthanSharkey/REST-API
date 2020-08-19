package com.inter_test.intern_test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

class StoreData

{
    private static AtomicLong counter; //= new AtomicLong();
    private static Set<Data> data; //= new HashSet<Data>();

    StoreData()
    {
        counter = new AtomicLong();
        data = new HashSet<>();
        addData();
    }

    public static void addData()
    {
        data.add(new Data((int) counter.incrementAndGet(), "My name is Ethan", "esharkey@test.ie"));
        data.add(new Data((int) counter.incrementAndGet(), "My name is Ali", "akennedy@test.ie"));
        data.add(new Data((int) counter.incrementAndGet(), "My name is Daniel","dan@test.ie"));
        data.add(new Data((int) counter.incrementAndGet(), "My name is Bart", "bart@test.ie"));
    }

    public static void addNonConstructorData(String info, String email)
    {
        data.add(new Data((int) counter.incrementAndGet(), info, email));
    }


    public static boolean delete(int id)
    {
        boolean isRemoved = data.removeIf(data -> (data.getId() == (id)));
        return isRemoved;
    }

    public static Set<Data> getData()
    {
        return data;
    }

    public static Set<Data> all()
    {
        return getData();
    }

    public static boolean updateAllData(int id, String text, String email)
    {
        for (Data info : data)
        {
            if (info.getId() == id)
            {
                info.setInfo(text);
                info.setEmail(email);
                return true;
            }
        }
        return false;
    }

    public static boolean updateGreetingData(int id, String text)
    {
        for (Data info : data)
        {
            if (info.getId() == id)
            {
                info.setInfo(text);
                return true;
            }
        }
        return false;
    }

    public static boolean updateEmailData(int id, String email)
    {
        for (Data info : data)
        {
            if (info.getId() == id)
            {
                info.setEmail(email);
                return true;
            }
        }
        return false;
    }
}
