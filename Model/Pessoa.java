package Model;

import java.util.Date; 
import Utils.Utils;

    public class Pessoa {
		private static int counter = 1;
		private int NumeroPessoa; 
		private String Name;
		private String CPF;
		private String Email;
		private Date AccountCreationDate;
		public Pessoa() { }

		public Pessoa(String Name, String CPF, String Email) { 
			this.NumeroPessoa = Pessoa.counter; 
			this.Name = Name;
			this.CPF = CPF;
			this.Email = Email;
			this.AccountCreationDate = new Date();
			 Pessoa.counter += 1;
		}

		public int getNumeroPessoa() { 
			return this.NumeroPessoa;
		}

		public String getName() { 
			return Name;
		}

		public void setName(String Name) { 
			this.Name = Name;
		}

		public String getCPF() { 
			return CPF;
		}

		public void setcpf(String CPF) { 
			this.CPF = CPF;
		}

		public String getEmail() { 
			return Email;
		}

		public void setEmail(String Email) { 
			this.Email = Email;
		}

		public Date getAccountCreationDate() { 
			return this.AccountCreationDate;
		}

		public String toString() {	
		return "\nName: " + this.getName() +
				"\nCPF: " + this.getCPF() +
				"\nEmail: " + this.getEmail() +
				"\nData: " + Utils.dateToString(this.getAccountCreationDate());
		}
	}
	
	


