package algo.string;

/**
 * KeyIndexedCounting
 */
public class KeyIndexedCounting {

    public static void sort(KV[] kvs) {

    }

    public static void main(String[] args) {

        KV[] kvs = new KV[20];
        kvs[0] = new KV(2,"Anderson");
        kvs[1] = new KV(3,"Brown");
        kvs[2] = new KV(3,"Davis");
        kvs[3] = new KV(4,"Garcia");
        kvs[4] = new KV(1,"Harris");
        kvs[5] = new KV(3,"Jackson");
        kvs[6] = new KV(4,"Johnson");
        kvs[7] = new KV(3,"Jones");
        kvs[8] = new KV(1,"Martin");
        kvs[9] = new KV(2,"Martinez");
        kvs[10] = new KV(2,"Miller");
        kvs[11] = new KV(1,"Moore");
        kvs[12] = new KV(2,"Robinson");
        kvs[13] = new KV(4,"Smith");
        kvs[14] = new KV(3,"Taylor");
        kvs[15] = new KV(4,"Thomas");
        kvs[16] = new KV(4,"Thompson");
        kvs[17] = new KV(2,"White");
        kvs[18] = new KV(3,"Williams");
        kvs[19] = new KV(4,"Wilson");

        sort(kvs);

    }

    public static class KV {

        public KV(int key,String val) {
            this.Key=key;
            this.value=val;
        }

        public int Key;
        public String value;
    }
}
