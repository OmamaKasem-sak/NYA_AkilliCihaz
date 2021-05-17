package com.sogutucuCihaz;

public class AgArayuzu implements IAgArayuzu 
{
    ISicaklikRepository sicaklikRepository = new SicaklikRepositoryPostgreSql();
    
    IEyleyici eyleyici1 = new Eyleyici();

    @Override
    public int sicaklikOku() 
    {
        return sicaklikRepository.sonSicaklikGetir();
    }

    @Override
    public void sogutucuAc() 
    {
    	eyleyici1.sogutucuAc();
    }

    @Override
    public void sogutucuKapat()
    {
    	eyleyici1.sogutucuKapat();
    }
}
