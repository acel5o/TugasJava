public class MyDate {
     		private int day = 1;
     		private int month = 1;
     		private int year = 2000;
    	
     		public MyDate(int day, int month, int year) {
     			this.day = day;
     			this.month = month;
     			this.year = year;
     		}
    		public MyDate(MyDate date) {
     			this.day = date.day;
     			this.month = date.month;
     			this.year = date.year;
             }
             
    
     		public MyDate addDays(int moreDays) {
     			
                this.day = this.day + moreDays;
     			// Not Yet Implemented: wrap around code...
     			return this;
            }

            public MyDate kurangDays(int moreDays) {
                
                this.day = this.day - moreDays;
                // Not Yet Implemented: wrap around code...
                return this;
           }

        public MyDate tambahBulan(int bulan) {
            this.month = this.month + bulan;
            // Not Yet Implemented: wrap around code...
            return this;
       }

       public MyDate tambahTahun(int tahun) {
        
        this.year = this.year + tahun;
        // Not Yet Implemented: wrap around code...
        return this;
       }
    
             public String toString() {
                   String retString = "" + day + "-" + month + "-" + year;
     			return retString;
     		}
			public void setDay(int day) {
                this.day = day;
			}
     	}
        