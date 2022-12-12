package entity;

import com.mycompany.merganom.Merganom;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;


public class NPC_Pani_profesor extends Entity{
    
    public NPC_Pani_profesor(Merganom gp){
        super(gp);
    }
    
    public void getNPCImage() throws FileNotFoundException, IOException{
        Pani_Profesor = ImageIO.read(new FileInputStream("res/NPC/Pani_profesor_1.png"));
    }
    
}

