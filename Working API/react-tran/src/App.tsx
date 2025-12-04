import './App.css'
import {Route, Routes} from "react-router";
import MainLayout from "./layouts/Main/MainLayout.tsx";
import UserHomePage from "./pages/user/UserHomePage/UserHomePage.tsx";
import RegisterPage from "./pages/account/RegisterPage/RegisterPage.tsx";
import NotFoundPage from "./pages/common/NotFoundPage.tsx";
import CreateCountryPage from "./pages/country/CreateCountryPage/CreateCountryPage.tsx";
import CreateCityPage from "./pages/city/CreateCityPage/CreateCityPage.tsx";
import CitiesListPage from "./pages/city/CitiesListPage/CitiesListPage.tsx";
import CityDetailPage from "./pages/city/CityDetailPage/CityDetailPage.tsx";

function App() {

    return (
        <>
            <Routes>
                <Route path="/" element={<MainLayout />}>
                    <Route index element={<UserHomePage/>} />

                    <Route path="/countries/create" element={<CreateCountryPage />} />

                    <Route path="cities">
                        <Route index element={<CitiesListPage/>} />
                        <Route path=":slug" element={<CityDetailPage/>} />
                        <Route path="create" element={<CreateCityPage />} />
                    </Route>

                    <Route path={"/register"} element={<RegisterPage/>} />
                </Route>

                <Route path="*" element={<NotFoundPage/>} />
            </Routes>
        </>
    )
}

export default App