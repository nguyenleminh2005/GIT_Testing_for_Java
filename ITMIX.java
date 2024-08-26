import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class ITMIX {
  static final int MAXN = (int) (4E5 + 5);
  static final int mod  = (int) (1E9 + 7); 

  public int st[] = new int[MAXN];
  public int lazy[] = new int[MAXN]; 
  public int assign[] = new int[MAXN]; 
  public int mul[] = new int[MAXN]; 

  public void refine(int id, int l, int r){
    int mid = (l + r) / 2; 
    if(assign[id] == 0){
      st[id << 1] = (int) ((1l * st[id << 1] * mul[id] + 1l * (mid - l + 1) * lazy[id]) % mod); 
      st[id << 1 | 1] = (int) ((1l * st[id << 1 | 1] * mul[id] + 1l * (r - mid) * lazy[id]) % mod); 
      lazy[id << 1] = (int) ((1l * lazy[id << 1] * mul[id] + lazy[id]) % mod); 
      lazy[id << 1 | 1] = (int) ((1l * lazy[id << 1 | 1] * mul[id] + lazy[id]) % mod);
      mul[id << 1]  = (int) ((1l * mul[id << 1] * mul[id]) % mod); 
      mul[id << 1 | 1] = (int) ((1l * mul[id << 1 | 1] * mul[id]) % mod); 
    }
    else{
      assign[id << 1] = assign[id << 1 | 1] = assign[id]; 
      lazy[id << 1] = lazy[id << 1 | 1] = lazy[id];
      st[id << 1] = (int) ((1l * lazy[id] * (mid - l + 1)) % mod); 
      st[id << 1 | 1] = (int) ((1l * lazy[id] * (r - mid)) % mod); 
      mul[id << 1]  = mul[id];  
      mul[id << 1 | 1] = mul[id];
      assign[id] = 0; 
    }
    lazy[id] = 0; 
    mul[id] = 1; 
  }

  public void update(int id, int l, int r, int u, int v, int x, int type){
    if(l > v || r < u) return;
    if(u <= l && r <= v){
      if(type == 1){
        st[id] = (int) ((1l * st[id] + 1l * x * (r - l + 1)) % mod); 
        lazy[id] = (lazy[id] + x) % mod;
        return;  
      }
      else if(type == 2){
        st[id] = (int) ((1l * st[id] * x) % mod); 
        lazy[id] = (int) ((1l * lazy[id] * x) % mod); 
        mul[id] = (int) ((1l * mul[id] * x) % mod); 
        return; 
      }
      else if(type == 3){
        st[id] = (int) ((1l * x * (r - l + 1)) % mod); 
        lazy[id] = x; 
        assign[id] = 1; 
        mul[id] = 1; 
        return; 
      }
    }
    refine(id, l, r);
    int mid = (l + r) / 2;
    update(id << 1, l, mid, u, v, x, type);
    update(id << 1 | 1, mid + 1, r, u, v, x, type);
    st[id] = (st[id << 1] + st[id << 1 | 1]) % mod; 
  }

  public int get(int id, int l, int r, int u, int v){
    if(l > v || r < u) return 0; 
    if(u <= l && r <= v) return st[id];
    refine(id, l, r);
    int mid = (l + r) / 2;
    int lf = get(id << 1, l, mid, u, v);
    int rg = get(id << 1 | 1, mid + 1, r, u, v); 
    return (lf + rg) % mod; 
  }

  static int N, M; 
  static Scanner scanner = new Scanner(System.in); 

  public static void main(String args[]){

    try {
      System.setIn(new FileInputStream("input.txt"));
      System.setOut(new PrintStream(new FileOutputStream("output.txt")));
      scanner = new Scanner(System.in);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
          

    ITMIX it = new ITMIX(); 
    Arrays.fill(it.mul, 1);
    
    N = scanner.nextInt();
    M = scanner.nextInt(); 
    
    for(int i = 1; i <= N; i++){
      int x = scanner.nextInt(); 
      it.update(1, 1, N, i, i, x, 1);
    }

    for(int i = 1; i <= M; i++){
      int type = scanner.nextInt(); 
      int l = scanner.nextInt();
      int r = scanner.nextInt();
      if(type == 4) System.out.println(it.get(1, 1, N, l, r)); 
      else{
        int x = scanner.nextInt(); 
        it.update(1, 1, N, l, r, x, type);
      }
    }
  }
}
