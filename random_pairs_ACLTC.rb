
class RandomPairs

	def initialize
		@separator = 0
		@students = ["Chelsea Troy","Trevor Jones","Ajay Ekesa","Charlie Jaime","Dany Han","Harper Essenfeld",
			"Jeff Rothschild","Mary Liz Lehman","Oscar Cisneros Jr.","Yedidya Weiner"].shuffle
		puts_students
	end

	def puts_students
		@students.each do |student|
			puts student
			create_pairs
		end 
	end

	def create_pairs
		if @separator%2 != 0
			puts
		end
		@separator += 1
	end
end

r = RandomPairs.new

