package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.repository.OfferRepository;
import org.springframework.samples.petclinic.service.OfferService;
import org.springframework.samples.petclinic.service.impl.OfferServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceTest {

	List<Offer> listOffers = new ArrayList<Offer>();

	@InjectMocks
	static OfferService service;

	@Mock
	private OfferRepository repository;

	@BeforeClass
	public static void testBeforeClass() {
		service = new OfferServiceImpl();
	}

	@Before
	public void testBefore() {
		Mockito.when(repository.findOne(1)).thenReturn(offerA);
		Mockito.when(repository.findOne(2)).thenReturn(offerB);

	}

	// Dates
	LocalDate localDate1 = LocalDate.of(2014, 2, 14);
	Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
	LocalDate localDate2 = LocalDate.of(2021, 3, 11);
	Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

	// Offers

	Offer offerA = new Offer("Gatos Gratis", "Oferta de Gatos", 30D, date1);
	Offer offerB = new Offer("Caes Gratis", "Oferta de caes", 10D, date2);
	List<Offer> lista = new ArrayList<Offer>(Arrays.asList(offerA, offerB));

	// TESTS

	@Test
	public void createOffer() {
		System.out.println("Create Offer");

		OfferService list1 = new OfferServiceImpl();
		OfferService list2 = new OfferServiceImpl();

		Offer offer1 = new Offer("Solidario", "Oferta de dinheiro", 5D, date1);
		
		list1.createOffer(offer1);

		System.out.println(list1.findAll().size() + " " + list2.findAll().size());

		assertEquals(1, (list1.findAll().size() - list2.findAll().size()));

	}

	@Test
	public void findById() {
		System.out.println("Find By Id :");
		assertEquals(offerA ,repository.findOne(1));
	}

	@Test
	public void findAll() {
		System.out.println("Find all");
		assertEquals(lista, repository.findAll());
		

	}

	@Test // TODO
	public void alterExpireDate() {


	}

	@Test // TODO
	public void deleteOffer() {

	}

	@Test // TODO
	public void findByExpireDateGreaterThan() {

	}

}