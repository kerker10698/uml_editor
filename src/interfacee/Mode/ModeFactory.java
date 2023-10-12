package interfacee.Mode;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class ModeFactory {

	public ModeFactory()
	{
		
	}
	
	public Mode make(String use, String imagePathNormal, String imagePathOn, int p, ModeListInterface _f)
	{
		switch(p)
		{
			case -1:
				return new ModeStub(use, imagePathNormal, imagePathOn, p, _f);
			case 0:
				return new SelectMode(use, imagePathNormal, imagePathOn, p, _f);
			case 1:
				return new AssociationLineMode(use, imagePathNormal, imagePathOn, p, _f);
			case 2:
				return new GeneralizationLineMode(use, imagePathNormal, imagePathOn, p, _f);
			case 3:
				return new CompositoinLineMode(use, imagePathNormal, imagePathOn, p, _f);
			case 4:
				return new ClassMode(use, imagePathNormal, imagePathOn, p, _f);
			case 5:
				return new UseCaseMode(use, imagePathNormal, imagePathOn, p, _f);
			default:
				System.out.println("wrong pattern no coresodding mode");
				return null;
		}
	}
}
