class ReadingPeople

	require 'httparty'

	attr_accessor :stereotype_wordcount, :hipster_wordcount, :drag_queen_wordcount, :fratboy_wordcount, :stereotype_name, :u

	def initialize
		@stereotype_wordcount = 0
		@hipster_wordcount = 0
		@drag_queen_wordcount = 0
		@fratboy_wordcount = 0
	end

	def get_article(url)
		@u = HTTParty.get(url).split(" ")
		read_website(@u)
	end

	def read_website(text)
		text.each do |word|
			is_hipster?(word)
			is_drag_queen?(word)
			is_fratboy?(word)
			is_stereotype?(word)
		end
		identify_stereotype
	end

	def is_hipster?(word) 
		hipster_words = ["mainstream", "obscure", "ironic", "you've probably never", "sourced"]
		@hipster_wordcount += 1 if hipster_words.include?(word)
	end

	def is_drag_queen?(word)
		drag_queen_words = ["sickening", "tuck", "read her to filth", "fierce", "werk"]
		@drag_queen_wordcount += 1 if drag_queen_words.include?(word)
	end

	def is_fratboy?(word)
		fratboy_words = ["dude", "broski", "bro", "mack", "sigma", "frat"]
		@fratboy_wordcount += 1 if fratboy_words.include?(word)
	end

	def is_stereotype?(word)
		if @wordlist != nil
		 @stereotype_wordcount += 1 if @wordlist.include?(word)
		end
	end

	def stereotype_word_list(word_list)
		@wordlist = word_list
	end

	def name_stereotype(name)
		@stereotype_name = name
	end

	def identify_stereotype
		a = [@stereotype_wordcount, @hipster_wordcount, @drag_queen_wordcount, @fratboy_wordcount]
		if a.max > 10
			return "hipster" if a.max == @hipster_wordcount
			return "drag queen" if a.max == @drag_queen_wordcount
			return "fratboy" if a.max == @fratboy_wordcount
			return @stereotype_name if a.max == @stereotype_wordcount
		else
			return nil 
		end
	end

end

r = ReadingPeople.new
r.get_article("http://www.tumblr.com/tagged/hipster-blog")