1. biến tham chiếu, tham trị trong map
// Object trong map sẽ thay đổi theo nếu biến tham chiếu thay đổi

public class Test {

	public static void main(String[] args) {
		 Map<String, Xe> soldiers = new HashMap<>();
		 Xe x1 =new Xe(1,2);
		 Xe x2 =new Xe(3,4);
		 
		 soldiers.put("s", x1);
		 soldiers.put("w", x2);
	    
		 Xe b = soldiers.get("s");
		 
		  System.out.println(b.getSoBanh()+","+b.getTocDo());
		  System.out.println(  soldiers.get("s").getSoBanh()+","+soldiers.get("s").getTocDo());
		  b.setSoBanh(6);
		  b.setTocDo(8);
		  System.out.println(b.getSoBanh()+","+b.getTocDo());
		  System.out.println(  soldiers.get("s").getSoBanh()+","+soldiers.get("s").getTocDo());
	}
}

class Xe {
	private int soBanh;

	private int tocDo;

	public Xe() {
		super();
	}

	public Xe(int soBanh, int tocDo) {
		this.soBanh = soBanh;
		this.tocDo = tocDo;
	}

	public int getSoBanh() {
		return soBanh;
	}

	public void setSoBanh(int soBanh) {
		this.soBanh = soBanh;
	}

	public int getTocDo() {
		return tocDo;
	}

	public void setTocDo(int tocDo) {
		this.tocDo = tocDo;
	}

}

// kết quả :
1,2
1,2
6,8
6,8

2 Tương tự phần 1 đối với list 

public static void main(String[] args) {
		 List soldiers = new ArrayList<>();
		 Xe x1 =new Xe(1,2);
		 Xe x2 =new Xe(3,4);
		 
		 soldiers.add(x1);
		 soldiers.add(x2);
	    
		 Xe b = (Xe) soldiers.get(0);
		 
		  System.out.println(b.getSoBanh()+","+b.getTocDo());
		  System.out.println(  ((Xe) soldiers.get(0)).getSoBanh()+","+((Xe) soldiers.get(0)).getTocDo());
		  b.setSoBanh(6);
		  b.setTocDo(8);
		  System.out.println(b.getSoBanh()+","+b.getTocDo());
		  System.out.println(  ((Xe) soldiers.get(0)).getSoBanh()+","+((Xe) soldiers.get(0)).getTocDo());
	}

// kết quả :
1,2
1,2
6,8
6,8


3.  nếu xử lý new phức tap thì clone sẽ nhanh hơn

public class Test {

	public static void main(String[] args) {
		 long startTime = System.currentTimeMillis();
		 
	        Board chessBoard = new Board();
	 
	        long endTime = System.currentTimeMillis();
	 
	        System.out.println("Time taken to create a board: " + (endTime - startTime) + " millis");
	        
	         startTime = System.currentTimeMillis();
			 
	        Board chessBoard2 = chessBoard.clone();
	 
	         endTime = System.currentTimeMillis();
	 
	        System.out.println("Time taken to create a board: " + (endTime - startTime) + " millis");
	 
}}
class Cell {
	 
    private String color;
    private String coordinate;
 
    public Cell(String color) {
        this.color = color;
    }
 
    @Override
    public String toString() {
        return "Cell [color=" + color + "]";
    }
}
 enum Color {
    BLACK, WHITE;
}
 class Board implements Cloneable{
    public static final int NO_OF_ROWS = 8;
    public static final int NO_OF_COLUMNS = 8;
 
    private final Cell[][] board;
 
    public Board()   {
        this.board = new Cell[NO_OF_ROWS][NO_OF_COLUMNS];
        Cell cell;
        for (int row = NO_OF_ROWS - 1; row >= 0; row--) {
            for (int col = NO_OF_COLUMNS - 1; col >= 0; col--) {
                if ((row + col) % 2 == 0) {
                    cell = new Cell(Color.WHITE.name());
                } else {
                    cell = new Cell(Color.BLACK.name());
                }
                board[row][col] = cell;
            }
        }
    }
    @Override
    protected Board clone() {
        try {
            return (Board) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// kết quả: 
Time taken to create a board: 1 millis
Time taken to create a board: 0 millis
