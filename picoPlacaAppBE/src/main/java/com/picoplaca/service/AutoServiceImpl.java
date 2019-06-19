package com.picoplaca.service;

import com.picoplaca.model.Auto;
import com.picoplaca.model.Consulta;
import com.picoplaca.model.Dias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AutoServiceImpl implements AutoService {
	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	private static List<Auto> autos = new ArrayList<>();
	private static List<Dias> dias = new ArrayList<>();
	static {
		autos.add(new Auto(1, "ABC-1234", "AZUL", "SEDAN", "123ASD3341D1234567", "MAZDA"));
		autos.add(new Auto(2, "ABC-1AD4", "AZUL", "SEDAN", "123ASD3341D1234567", "VOLKSWAGEN"));
		autos.add(new Auto(3, "ABC-AD", "AZUL", "CAMIONETA", "123ASD3341D1234567", "TOYOTA"));
		try {
			dias.add(new Dias(1, "LUNES", format.parse("07:00"), format.parse("09:30"), format.parse("16:00"),
					format.parse("19:30"), 2));

			dias.add(new Dias(2, "MARTES", format.parse("07:00"), format.parse("09:30"), format.parse("16:00"),
					format.parse("19:30"), 4));
			dias.add(new Dias(3, "MIERCOLES", format.parse("07:00"), format.parse("09:30"), format.parse("16:00"),
					format.parse("19:30"), 6));
			dias.add(new Dias(4, "JUEVES", format.parse("07:00"), format.parse("09:30"), format.parse("16:00"),
					format.parse("19:30"), 8));
			dias.add(new Dias(5, "VIERNES", format.parse("07:00"), format.parse("09:30"), format.parse("16:00"),
					format.parse("19:30"), 9));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Auto> getAllAutos() {
		return autos;
	}

	@Override
	public String getCosulta(String placa, Date fecha, Date hora1) {
		String msg = "";

		int digP = Integer.parseInt(placa.substring(placa.length() - 1, placa.length()));
		Date hora = new Date();
		String aux=format.format(hora1);
		int dia = fecha.getDay();
		try {

			hora = format.parse(aux);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dia != 0 || dia != 6) {
			for (Dias diaC : dias) {
				if (diaC.getnDia() == dia) {
					if (digP <= diaC.getPlaca()) {
						if ((hora.after(diaC.getHora1()) && hora.before(diaC.getHora11()))
								|| (hora.after(diaC.getHora2()) && hora.before(diaC.getHora21()))) {
							msg = "El vehículo de placas " + placa + " no puede salir";
						} else {
							msg = "El vehículo de placas " + placa + " puede salir";
						}
					}
				}
			}

		} else {
			switch (dia) {
			case 0:
				msg = "El día Domingo no se aplica pico y placa \n puede salir";
				break;
			case 6:
				msg = "El dia Sábado no se aplica pico y placa \n puede salir";
				break;
			}
		}

		return msg.toUpperCase();
	}

	@Override
	public Auto getAutoById(int id) {
		for (Auto auto : autos) {
			if (auto.getId() == id) {
				return auto;
			}
		}
		return null;
	}

	@Override
	public Auto addAuto(Auto auto) {
		Random random = new Random();
		int nextId = random.nextInt(1000) + 10;

		auto.setId(nextId);
		autos.add(auto);

		return auto;
	}
    

}