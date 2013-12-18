package models;

import com.google.gson.internal.LinkedTreeMap;
import config.Config;
import controllers.FroshController;

/**
 * Created by neowutran on 14/12/13.
 */
public class TheEnd extends Thread{


    @Override
    public void run( ) {

        FroshController.getInstance().getGrid().show();
        while( !FroshController.getInstance().getGridModel().hasEnded()) {

            try {
                Thread.sleep( ( ( Double ) ( (LinkedTreeMap<?, ?>) Config
                        .getConfiguration().get( "controller" ) )
                        .get( "msBeforeNextDay" ) ).intValue( ) );
            } catch( final InterruptedException e ) {
                // Ce catch est juste la pour ne pas propager cette exception dont je me fout eperdument
            }


            if(FroshController.getInstance().getKill()){
                return;
            }

            while(FroshController.getInstance().getStop()){
                try {
                    Thread.sleep( ( ( Double ) ( (LinkedTreeMap<?, ?>) Config
                            .getConfiguration().get( "controller" ) )
                            .get("msBeforeNextDay") ).intValue( ) );
                } catch( final InterruptedException e ) {
                    // Ce catch est juste la pour ne pas propager cette exception dont je me fout eperdument

                }
            }
             
            FroshController.getInstance().nextDay();

        }
    }
}
