class LBException extends Exception{
	LBException(){
		super();
	}

	public String toString(){
		return "Balance is Low";
	}

}