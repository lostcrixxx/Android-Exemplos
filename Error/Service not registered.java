Se em sua Atividade, unbindService () for chamado antes de bindService (), você receberá isso IllegalArgumentException.

Como evitá-lo?
É simples. Você não precisaria de um sinalizador booleano se vincular e desvincular o serviço nesta ordem.

Solução 1:

Vincular onStart()e desassociaronStop()

Your Activity {

    @Override
    public void onStart()
    {
        super.onStart();
//		  Intent in = new Intent(this, SyncService.class);
//        this.bindService(in, mConnection, Context.BIND_AUTO_CREATE);
        bindService(intent, mConnection , Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        unbindService(mConnection);
    }

 } 
Solução 2:
vincular onCreate()e desassociaronDestroy()

 Your Activity {

    @Override
    public void onCreate(Bindle sis)
    {
        super.onCreate(sis);
        ....
        bindService(intent, mConnection , Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        unbindService(mConnection);
    }         

 }
Link relevante:
A documentação oficial do Android sugere que,
se você precisar interagir com o serviço apenas enquanto sua atividade estiver visível , vá com a Solução1 .
Se você deseja que sua atividade receba respostas mesmo enquanto está parada em segundo plano , vá com a Solução2 .