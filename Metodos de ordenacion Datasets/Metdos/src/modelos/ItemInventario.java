package modelos;

public class ItemInventario {

    private final String id;
    private final String insumo;
    private final int stock;

    public ItemInventario(String id, String insumo, int stock) {
        this.id = id;
        this.insumo = insumo;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getInsumo() {
        return insumo;
    }

    public int getStock() {
        return stock;
    }

    //calve de ordenamiento
    public int clave() {
        return stock;
    }

    @Override
    public String toString() {
        return id + " - " + insumo + " - " + stock;
    }
}
