class Recipe < ActiveRecord::Base

  def ingredient_list
    return ingredients.split(",")
  end

  def directions_list
    return directions.split(",")
  end

  def author_initials
    name_array = author.split(" ")
    author_initials = ""

    name_array.each do |name|
     author_initials += name.split("").first.upcase + "."
    end

    return author_initials
  end 

  def date_created
    return created_at.strftime("%b %e, %l:%M %p")
  end
 
  def date_updated
    return updated_at.strftime("%b %e, %l:%M %p")
  end

end
