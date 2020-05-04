package com.vtex.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.List;

@Service
public class ConselhoService {
    public static final String ACCOUNT_SID =
            "ACCOUNT_SID";
    public static final String AUTH_TOKEN =
            "AUTH_TOKEN";


    public ResponseEntity<?> conselhoSms(){
    	String numberTo = "";
    	String numberFrom = "";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        	for(int i=0;i<5;i++){
        		if(i==0){
        			Message message = Message
	                .creator(new PhoneNumber(numberTo), // to
	                        new PhoneNumber(numberFrom), // from
	                        "O seu lucro no último mês foi inferior ao do mês anterior, procure e corte despesas desnecessárias para o crescimento do negócio.")
	                .create();
        		}
        		if(i==1){
        			Message message = Message
	                .creator(new PhoneNumber(numberTo), // to
	                        new PhoneNumber(numberFrom), // from
	                        "O seu lucro no último mês foi pouco significativo, procure elaborar um plano de negócios que melhore o lucro da empresa, o Canvas é uma ferramenta que pode te ajudar nisso. Lembre-se de que, se você invalida uma ideia em pouco tempo, o prejuízo é menor, por isso não tenha medo de mudar sua estratégia de negócio.")
	                .create();
        		}
        		if(i==2){
        			Message message = Message
	                .creator(new PhoneNumber(numberTo), // to
	                        new PhoneNumber(numberFrom), // from
	                        "Viva!!!  O seu lucro no último mês foi pelo menos 10% maior que no anterior, aproveite para investir em cursos de administração que te ajudarão a melhorar sua visão de empreendedor, tire um tempo também para conhecer melhor seus clientes e quais são suas necessidades, assim poderá atendê-los de forma ainda melhor.")
	                .create();
        		}
        		if(i==3){
        			Message message = Message
	                .creator(new PhoneNumber(numberTo), // to
	                        new PhoneNumber(numberFrom), // from
	                        "Parabéns!!! O seu lucro continuou a crescer esse mês, invista na divulgação de seu negócio e lembre-se de separar os gastos da empresa dos gastos pessoais, para que não veja todo o lucro sumir do seu caixa.")
	                .create();
        		}
        		if(i==4){
        			Message message = Message
	                .creator(new PhoneNumber(numberTo), // to
	                        new PhoneNumber(numberFrom), // from
	                        "Incrível!!! O seu lucro cresceu ainda mais no último mês, invista em equipamentos ou funcionários caso as demandas da empresa estejam começando a te sobrecarregar.")
	                .create();
        		}
        	}

        return ResponseEntity.ok().body("Conselhos enviados");
    }
}
